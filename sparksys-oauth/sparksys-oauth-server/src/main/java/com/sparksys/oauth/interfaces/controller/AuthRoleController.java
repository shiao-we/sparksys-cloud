package com.sparksys.oauth.interfaces.controller;

import com.github.pagehelper.PageInfo;
import com.sparksys.core.entity.AuthUserInfo;
import com.sparksys.log.annotation.WebLog;
import com.sparksys.oauth.application.service.IAuthRoleService;
import com.sparksys.oauth.infrastructure.entity.AuthRole;
import com.sparksys.oauth.interfaces.dto.role.AuthRoleDTO;
import com.sparksys.oauth.interfaces.dto.role.AuthRoleSaveDTO;
import com.sparksys.oauth.interfaces.dto.role.AuthRoleUpdateDTO;
import com.sparksys.oauth.interfaces.dto.role.RoleUserDTO;
import com.sparksys.web.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * description: 角色 前端控制器
 *
 * @author zhouxinlei
 * @date 2020-06-07 13:40:03
 */
@RestController
@RequestMapping("/role")
@ResponseResult
@WebLog
@Api(tags = "角色管理")
public class AuthRoleController {

    private final IAuthRoleService authRoleService;

    public AuthRoleController(IAuthRoleService authRoleService) {
        this.authRoleService = authRoleService;
    }


    @ApiOperation("查询角色列表")
    @GetMapping("/role/page")
    public PageInfo<AuthRole> listByPage(Integer pageNum, Integer pageSize,
                                         @RequestParam(value = "name", required = false) String name) {
        return authRoleService.listByPage(pageNum, pageSize, name);
    }

    @ApiOperation("获取角色信息")
    @GetMapping("/role/{id}")
    public AuthRoleDTO getAuthRole(@PathVariable("id") Long id) {
        return authRoleService.getAuthRole(id);
    }


    @ApiOperation("保存角色信息")
    @PostMapping("/role")
    public boolean saveAuthRole(@ApiIgnore AuthUserInfo authUserInfo, @Validated @RequestBody AuthRoleSaveDTO authRoleSaveDTO) {
        return authRoleService.saveAuthRole(authUserInfo.getId(), authRoleSaveDTO);
    }

    @ApiOperation("更新角色信息")
    @PutMapping("/role")
    public boolean updateAuthRole(@ApiIgnore AuthUserInfo authUserInfo, @Validated @RequestBody AuthRoleUpdateDTO authRoleUpdateDTO) {
        return authRoleService.updateAuthRole(authUserInfo.getId(), authRoleUpdateDTO);
    }

    @ApiOperation("删除角色信息")
    @DeleteMapping("/role/{id}")
    public boolean deleteAuthRole(@PathVariable("id") Long id) {
        return authRoleService.deleteAuthRole(id);
    }

    @ApiOperation("更新角色状态")
    @PatchMapping("/role/{id}")
    public boolean updateAuthRoleStatus(@ApiIgnore AuthUserInfo authUserInfo, @PathVariable("id") Long id,
                                        @RequestParam(value = "status") Boolean status) {
        return authRoleService.updateAuthRoleStatus(authUserInfo.getId(), id, status);
    }




}
