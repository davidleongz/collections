package com.example.collections.dto;


import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class OrderListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> orderList;

}
