package com.kh.onemile.util;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//무작위숫자 생성
@Component
public class RandomUtilImpl implements RandomUtil{
	
	private Random r = new Random();
	
	@Override
	public String RandomNumber(int size) {
		int range =  (int) Math.pow(10, size);//범위
		int number = r.nextInt(range);

		StringBuffer buffer = new StringBuffer();
		for(int i=0; i < size; i++) {
			buffer.append("0");
		}
		Format f = new DecimalFormat(buffer.toString());
		
		return f.format(number);
		}
	}