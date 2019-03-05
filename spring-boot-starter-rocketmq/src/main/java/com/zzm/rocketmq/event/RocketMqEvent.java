package com.zzm.rocketmq.event;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationEvent;


public class RocketMqEvent extends ApplicationEvent{

	private static final long serialVersionUID = 8510775274696089620L;

	public RocketMqEvent(Object source) {
		super(source);
	}

	private DefaultMQPushConsumer consumer;
	private MessageExt messageExt;
	private String topic;

	public RocketMqEvent(MessageExt msg, DefaultMQPushConsumer consumer){
		super(msg);
		this.consumer = consumer;
		this.messageExt = msg;
		this.setTopic(msg.getTopic());
	}

	public DefaultMQPushConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(DefaultMQPushConsumer consumer) {
		this.consumer = consumer;
	}

	public MessageExt getMessageExt() {
		return messageExt;
	}

	public void setMessageExt(MessageExt messageExt) {
		this.messageExt = messageExt;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
