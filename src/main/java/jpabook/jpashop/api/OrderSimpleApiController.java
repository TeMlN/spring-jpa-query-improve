package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

     private final OrderRepository orderRepository;

     @GetMapping("/api/vi/simple-orders")
     public List<Order> ordersV1() {
         List<Order> allByString = orderRepository.findAllByString(new OrderSearch());
         for (Order order : allByString) {
             order.getMember().getName(); //강제 초기화
             order.getDelivery().getAddress(); //강제 초기화
         }
         return allByString;

     }

     


}