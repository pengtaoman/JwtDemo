package com.me.security.service.imp;

import com.me.model.security.User;
import com.me.security.repository.UserRepository;
import com.me.security.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    public String addUser(User user) {

        final User user1 = userRepository.findByUsername(user.getUsername());
        //System.out.println("$$$$$$$$$$"+user1.getUsername());
        if(user1!=null)
        {
            return "此用户名已存在";
        }
        else {
            user.setId(Long.parseLong("12312"));

            user.setEmail("h.xin@qq.com");
            user.setFirstname("1111");
            user.setLastname("22222");
            user.setEnabled(true);
            BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

            user.setPassword(enc.encode(user.getPassword()));

            user.setLastPasswordResetDate(new Date());

            User aa = userRepository.save(user);

            System.out.println("RegisterServiceImpl" + aa);
            return "创建成功";
        }

    }
}
