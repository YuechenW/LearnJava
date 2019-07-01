package util;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import constant.Constant;

public class ImageUtil {
	public static Map<String,Image> images = new HashMap<>();
	
	static{
		images.put("snake_body", GameUtil.getImage(Constant.IMG_PRE+"snake_body.png"));//�Լ����
		
		/*
		 * ���ʳ��ͼƬ����Դ��һ���׶�ʶͼ��һ��һ��pС�ġ�����
		 */
		images.put("pineapple", GameUtil.getImage(Constant.IMG_PRE+"pineapple_pic.png"));
		images.put("apple", GameUtil.getImage(Constant.IMG_PRE+"apple_pic.png"));
		images.put("banana", GameUtil.getImage(Constant.IMG_PRE+"banana_pic.png"));
		images.put("cherry", GameUtil.getImage(Constant.IMG_PRE+"cherry_pic.png"));
		images.put("grape", GameUtil.getImage(Constant.IMG_PRE+"grape_pic.png"));
		images.put("orange", GameUtil.getImage(Constant.IMG_PRE+"orange_pic.png"));
		images.put("pear", GameUtil.getImage(Constant.IMG_PRE+"pear_pic.png"));
		images.put("strawberry", GameUtil.getImage(Constant.IMG_PRE+"strawberry_pic.png"));
		images.put("watermelon", GameUtil.getImage(Constant.IMG_PRE+"watermelon_pic.png"));
		images.put("mango", GameUtil.getImage(Constant.IMG_PRE+"mango_pic.png"));
		
		images.put("snake_head", GameUtil.getImage(Constant.IMG_PRE+"snake_head.png"));//�Լ���
		images.put("background", GameUtil.getImage(Constant.IMG_PRE+"background.jpg"));//��Դ����
		images.put("fail", GameUtil.getImage(Constant.IMG_PRE+"fail.png"));//��Դ�ɻ���ս
	}
}
