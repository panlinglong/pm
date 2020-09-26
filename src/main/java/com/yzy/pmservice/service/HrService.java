package com.yzy.pmservice.service;

import com.yzy.pmservice.mapper.HrMapper;
import com.yzy.pmservice.mapper.Hr_roleMapper;
import com.yzy.pmservice.pojo.Empdeal;
import com.yzy.pmservice.pojo.Hr;
import com.yzy.pmservice.pojo.Kehu;
import com.yzy.pmservice.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private Hr_roleMapper hrRoleMapper;

    public  List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer updatePw(Hr hr) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        hr.setPassword(encoder.encode(hr.getPassword()));
        hr.setEnabled(true);
        System.out.println(hr.getPassword());
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid,rids)==rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public Integer addHr(Hr hr) {
        hr.setEnabled(true);
        Integer result = hrMapper.insertSelective(hr);

        return result;
    }

}
