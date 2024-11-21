package chapter03;

public class GoodsApp {
    public static void main(String[] args) {
        Goods goods = new Goods();

        // 인스턴스 변수
//        goods.name = "nikon";
//        goods.price = 400000;
//        goods.countSold = 10;
//        goods.countStock = 20;

        goods.setName("Nikon");
        goods.setPrice(400000);
        goods.setCountSold(10);
        goods.setCountStock(20);

        goods.printInfo();

        goods.setPrice(-1000);

        Goods goods2 = new Goods();
        Goods goods3 = new Goods();

        System.out.println(Goods.countOfGoods);

        goods.setPrice(400000);
        System.out.println(goods.calcDiscountPrice(0.5f));
    }
}