package com.example.collections.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.example.collections.dto.OrderListDTO; 
import com.example.collections.util.JsonTools;


@SpringBootTest
public class ListTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListTests.class);

	@Test
	public void getValuesNotExistFromArrayList() {

		OrderListDTO orderSmallList = JsonTools.convertJsonFileToObjecDto("json", "jsonSmallList.json",
				OrderListDTO.class);
		OrderListDTO orderLargeList = JsonTools.convertJsonFileToObjecDto("json", "jsonLargeList.json",
				OrderListDTO.class);

		final List<String> ordersNotRepeated = new ArrayList<String>();

		if (!CollectionUtils.isEmpty(orderSmallList.getOrderList())
				&& !CollectionUtils.isEmpty(orderLargeList.getOrderList())) {

			for (final String order : orderLargeList.getOrderList()) {

				if (!orderSmallList.getOrderList().contains(order)) {
					ordersNotRepeated.add(order);
				}
			}

			LOGGER.info("Number of orders: {}", ordersNotRepeated.size());
			LOGGER.info(ordersNotRepeated.toString());
		}

		assertEquals(ordersNotRepeated.size(), 14);
	}

}
