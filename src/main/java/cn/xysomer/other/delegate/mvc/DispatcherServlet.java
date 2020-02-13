package cn.xysomer.other.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description DispatcherServlet
 * @Author Somer
 * @Date 2020-02-13 14:25
 */
public class DispatcherServlet extends HttpServlet {

    // Handler初始化
    private List<Handler> handlerMapping = new ArrayList<>();

    /**
     * 初始化
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        try {
            Class<?> orderClass = OrderController.class;
            handlerMapping.add(new Handler()
                    .setController(orderClass.newInstance())
                    .setMethod(orderClass.getMethod("getOrderById", String.class))
                    .setUri("/order/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatcher(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatcher(HttpServletRequest request, HttpServletResponse response) {
        // 获取用户的请求 uri
        String uri = request.getRequestURI();
        // 获取到 uri 之后，根据 uri 找到对应到方法
        // 通过拿到到的 uri 去 handlerMapping 中遍历(策略模式)
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUri())) {
                handler = h;
                break;
            }
        }
        //  将具体的任务委派给对应的 controller 中的 method
        // 通过反射调用对应的方法
        try {
            Object object = handler.getMethod().invoke(handler.getController(), request.getParameter("id"));
            try {
                // 获取到 Method 执行的结果，进行返回
                response.getWriter().write(object.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    class Handler {

        private Object controller;
        private Method method;
        private String uri;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUri() {
            return uri;
        }

        public Handler setUri(String uri) {
            this.uri = uri;
            return this;
        }
    }
}
