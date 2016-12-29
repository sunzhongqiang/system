package com.mmk.trade.condition;

public enum TuanOrderStatus {
	
	 /**
     * 订单状态：
	*	wait_pay:待付款;
	*	wait_join:待成团;
	*   WAIT_CHOOSE:待开奖;
	*	wait_shipping待发货;
	*	wait_receive:待收货;
	*	wait_comment:待评价;
	*	successed:已完成;
	*	wait_refund_goods:待退货
	*	wait_refund_money:待退款
	*	closed:已关闭; 
    * 
    */
	WAIT_PAY,WAIT_JOIN,WAIT_CHOOSE,WAIT_SHIPPING,WAIT_RECEIVE,WAIT_COMMENT,SUCCESSED,WAIT_REFUND_GOODS,WAIT_REFUND_MONEY,CLOSED
}
