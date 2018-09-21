package com.mos.eboot.api.platform.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mos.eboot.platform.entity.UserInfo;
import com.mos.eboot.tools.result.ResultModel;

/**
 * @author 小尘哥
 */
@FeignClient("boot-service")
public interface IUserInfoService {

	/**
	 * 根据用户名获取user
	 * @param username
	 * @return
	 */
    @RequestMapping("userInfo/get-by-name")
    UserInfo getByUsername(@RequestParam("username") String username);

	/**
	 * 新增/修改
	 * @param sysUser
	 * @return
	 */
	@RequestMapping("userInfo/save-or-update")
	ResultModel<String> saveOrUpdate(@RequestBody UserInfo userInfo);
}
