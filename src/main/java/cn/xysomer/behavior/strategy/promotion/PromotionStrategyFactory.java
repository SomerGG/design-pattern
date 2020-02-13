package cn.xysomer.behavior.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 优惠策略工厂
 * @Author Somer
 * @Date 2020-02-13 13:37
 */
public class PromotionStrategyFactory {

    private static final Map<String, IPromotionStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        STRATEGY_MAP.put(PromotionKey.CASHBACK, new CashBackStrategy());
        STRATEGY_MAP.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());
    }

    private static final IPromotionStrategy EMPTY_STRATEGY = new EmptyStrategy();

    private PromotionStrategyFactory() {
    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy promotionStrategy = STRATEGY_MAP.get(promotionKey);
        return null == promotionKey ? EMPTY_STRATEGY : promotionStrategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
