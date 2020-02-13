package cn.xysomer.behavior.strategy;

import cn.xysomer.behavior.strategy.promotion.PromotionActivity;
import cn.xysomer.behavior.strategy.promotion.PromotionStrategyFactory;

/**
 * @Description 策略模式测试
 * @Author Somer
 * @Date 2020-02-13 13:08
 */
public class StrategyTest {

    public static void main(String[] args) {
        String promotionKey = "CASHBACK";
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.execute();
    }
}
