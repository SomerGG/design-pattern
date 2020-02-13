package cn.xysomer.behavior.strategy.promotion;

/**
 * @Description 优惠券
 * @Author Somer
 * @Date 2020-02-13 12:57
 */
public class CouponStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，下单直接减免");
    }
}
