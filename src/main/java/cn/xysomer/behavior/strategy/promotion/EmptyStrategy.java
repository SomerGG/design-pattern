package cn.xysomer.behavior.strategy.promotion;

/**
 * @Description 无优惠
 * @Author Somer
 * @Date 2020-02-13 12:55
 */
public class EmptyStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("无促销活动，原价");
    }
}
