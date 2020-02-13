package cn.xysomer.behavior.strategy.promotion;

/**
 * @Description 组团
 * @Author Somer
 * @Date 2020-02-13 12:59
 */
public class GroupBuyStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("拼团优惠，5人成团，享受团购价");
    }
}
