//package com.example.demo;
//
//import com.example.demo.Constants.OrderConstants;
//import com.example.demo.dao.IAddressDAO;
//import com.example.demo.dao.IOrderDAO;
//import com.example.demo.entity.EntityAddress;
//import com.example.demo.entity.EntityOrder;
//import com.example.demo.exception.OrderNotFoundException;
//import com.example.demo.service.IOrderService;
//import com.example.demo.service.impl.OrderServiceImpl;
//import com.example.demo.translator.IItemTranslator;
//import com.example.demo.translator.IOrderTranslator;
//import com.example.demo.vo.OrderVO;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//@ExtendWith(MockitoExtension.class)
//public class OrderServiceImplTest {
//
//    @Mock
//    IOrderDAO iOrderDAO;
//
//    @Mock
//    private IOrderTranslator iOrderTranslator;
//
//    @Mock
//    private IItemTranslator iItemTranslator;
//
////    @Spy
//    @InjectMocks
//    private IOrderService mokOrdSvc;
//
//
////    @Before
////    public void setup() {
////        MockitoAnnotations.initMocks(this); // Moving this below the next line fixed it...
////        mokOrdSvc = new IOrderService() {
////            @Override
////            public OrderVO getOrderById(Long orderId) {
////                return null;
////            }
////
////            @Override
////            public EntityOrder placeOrder(EntityOrder entityOrder) {
////                return null;
////            }
////
////            @Override
////            public EntityOrder cancelOrderById(Long orderId) {
////                return null;
////            }
////
////            @Override
////            public void createOrders(List<EntityOrder> orders) {
////
////            }
////        }; // But just remove this line and let Mockito do the work
////    }
//
//    @Test
//    public void getOrderById() {
//        EntityOrder entityOrder = new EntityOrder();
//        entityOrder.setOrder_id(1L);
//        entityOrder.setOrder_status(OrderConstants.CREATED.toString());
//        Mockito.when(iOrderDAO.findById(1L)).thenReturn(Optional.of(entityOrder));
//        assertEquals(entityOrder, mokOrdSvc.getOrderById(1L));
//
//        Mockito.when(iOrderDAO.findById(2L)).thenReturn(Optional.empty());
//        assertThrows(OrderNotFoundException.class, () -> mokOrdSvc.getOrderById(34L));
//    }
//
//
//
//}