package com.nishs.spring.feign.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.nishs.spring.feign.api.dto.UserResponse;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="user-client")
public interface UserClient {

	@GetMapping("/users")
	public List<UserResponse> getUser();
}
