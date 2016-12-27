package com.mmk.refund.constants;

public enum RefundStatus {
	
	/**
	 * WAIT_SELLER_AGREE:等待卖家同意
	 * SELLER_REFUSE_BUYER:卖家拒绝退款
	 * WAIT_REFUND_GOODS：等待退货
	 * WAIT_SELLER_CONFIRM_GOODS:等待卖家确认收货
	 * WAIT_REFUND_MONEY：等待退款
	 * SUCCESSED:退款成功
	 * CLOSED：退款取消关闭
	 */
	
	WAIT_SELLER_AGREE,SELLER_REFUSE_BUYER,WAIT_REFUND_GOODS,WAIT_SELLER_CONFIRM_GOODS,WAIT_REFUND_MONEY,CLOSED,SUCCESSED

}
