//package com.communicator.services.utils;
//
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//
//import java.util.Map;
//
//@Component
//public class UserHandshakeInterceptor implements HandshakeInterceptor {
//
//    /**
//     * Before Handshake.
//     * @param request
//     * @param response
//     * @param wsHandler
//     * @param attributes
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean beforeHandshake(final ServerHttpRequest request, final ServerHttpResponse response,
//                                   final WebSocketHandler wsHandler,
//                                   final Map<String, Object> attributes) throws Exception {
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            String phoneNumber = servletRequest.getServletRequest().getParameter("phoneNumber");
//            if (phoneNumber == null || phoneNumber.isEmpty()) {
//                throw new IllegalArgumentException("Phone number is required for WebSocket connection.");
//            }
//
//            attributes.put("phoneNumber", phoneNumber);
//
//
//        }
//        return true;
//    }
//
//    @Override
//    public void afterHandshake(final ServerHttpRequest request, final ServerHttpResponse response,
//                               final WebSocketHandler wsHandler, final Exception exception) {
//        // EMPTY METHOD
//    }
//}
