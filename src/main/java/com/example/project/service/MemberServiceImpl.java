package com.example.project.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.dto.LoginDTO;
import com.example.project.dto.MemberDTO;
import com.example.project.dto.Role;
import com.example.project.mapper.MemberMapper;
import com.example.project.oauth2.ProviderUser;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService, UserDetailsService{
	
	private final MemberMapper mapper;

	@Override
	public int memberAdd(MemberDTO dto, PasswordEncoder passwordEncoder) throws Exception {
		dto.setPasswd(passwordEncoder.encode(dto.getPasswd()));
		dto.setRoles(Role.USER);
		return mapper.memberAdd(dto);
	}
	
	@Override
	public MemberDTO login(LoginDTO dto) throws Exception {
		return mapper.login(dto);
	}

	@Override

	public MemberDTO mypage(String userid) throws Exception {
		return mapper.mypage(userid);
	}
	
	@Override
	public int memberUpdate(MemberDTO dto) throws Exception {
		return mapper.memberUpdate(dto);
	}

	@Override
	public int memberDelete(MemberDTO dto) throws Exception {
		return mapper.memberDelete(dto);
	}


	public MemberDTO findByEmail(String email) {
		return mapper.findByEmail(email);
	}
	
	@Override
	public int saveSocialUser(String registrationId, ProviderUser providerUser) {
		MemberDTO dto = new MemberDTO();
		dto.setEmail(providerUser.getEmail());
		dto.setPasswd(providerUser.getPassword());
		dto.setRegistrationId(registrationId);
		
		return mapper.memberAdd(dto);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDTO dto = mapper.findByEmail(username);
		if(dto == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder()
                .username(dto.getEmail())
                .password(dto.getPasswd())
                .roles(dto.getRoles().toString())
                .build();
	}

}
