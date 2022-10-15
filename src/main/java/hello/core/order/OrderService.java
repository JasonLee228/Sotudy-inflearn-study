package hello.core.order;

public interface OrderService {

    /**
     * TODO: 주문을 위한 파라미터를 받아 주문을 생성한다.
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return 주문 결과
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
