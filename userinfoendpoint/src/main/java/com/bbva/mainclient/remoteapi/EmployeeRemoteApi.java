package com.bbva.mainclient.remoteapi;

import com.bbva.employeeservice.api.EmployeeService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by icanon on 28/10/16.
 */

@FeignClient("employeeservice")
public interface EmployeeRemoteApi extends EmployeeService {
}
