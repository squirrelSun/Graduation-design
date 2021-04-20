package com.sust.swy.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sust.swy.crowd.entity.Menu;
import com.sust.swy.crowd.entity.MenuExample;
import com.sust.swy.crowd.mapper.MenuMapper;
import com.sust.swy.crowd.service.api.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getAll() {
		return menuMapper.selectByExample(new MenuExample());
	}
	
}
