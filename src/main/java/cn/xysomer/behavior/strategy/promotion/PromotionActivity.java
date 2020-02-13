package cn.xysomer.behavior.strategy.promotion;

/**
 * @Description 发布优惠
 * @Author Somer
 * @Date 2020-02-13 13:06
 */
public class PromotionActivity {

    IPromotionStrategy promotionStrategy;

    public PromotionActivity(IPromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute() {
        promotionStrategy.doPromotion();
    }
}
