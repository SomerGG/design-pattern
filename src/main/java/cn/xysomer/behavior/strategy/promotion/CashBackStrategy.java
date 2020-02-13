package cn.xysomer.behavior.strategy.promotion;

/**
 * @Description 返现
 * @Author Somer
 * @Date 2020-02-13 12:58
 */
public class CashBackStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销，订单完成之后直接返现到支付账号余额");
    }
}
