package tn.mahjoub.rdv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.mahjoub.rdv.exception.BadRequestException;
import tn.mahjoub.rdv.exception.NotFoundException;
import tn.mahjoub.rdv.exception.UnauthorizedException;
import tn.mahjoub.rdv.repository.UsersRepo;
import tn.mahjoub.rdv.security.JwtUtils;
import tn.mahjoub.rdv.model.LoginBody;
import tn.mahjoub.rdv.model.LoginResponse;
import tn.mahjoub.rdv.model.Roles;
import tn.mahjoub.rdv.model.Users;
import tn.mahjoub.rdv.service.GenericService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersService implements GenericService<Users, Long> {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Users save(Users entity) {
        try {
            entity.setSpeciality(specialityService.findById(entity.getSpecialityId()));
            entity.setRoles(Roles.PASSION);
            return usersRepo.save(entity);
        } catch (Exception ex) {
            throw new BadRequestException("Error add user. " + ex.getMessage());
        }
    }

    @Override
    public Users update(Users entity, Long aLong) {
        try {
            Users user = findById(aLong);
            user.setNom(entity.getNom());
            user.setPrenom(entity.getPrenom());
            user.setGenre(entity.getGenre());
            user.setTelephone(entity.getTelephone());
            user.setSpeciality(specialityService.findById(entity.getSpecialityId()));
            return usersRepo.save(entity);
        } catch (Exception ex) {
            throw new BadRequestException("Error add user. " + ex.getMessage());
        }
    }

    @Override
    public boolean delete(Long aLong) {
        try {
            usersRepo.deleteById(aLong);
            return true;
        } catch (Exception e) {
            throw new NotFoundException("User Not Found.");
        }
    }

    @Override
    public Users findById(Long aLong) {
        try {
            return usersRepo.findById(aLong).get();
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("User { id: %s } Not Found. ", aLong));
        }
    }

    public Users findByUsername(String username) {
        try {
            return usersRepo.findByUsername(username);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("User { email: %s } Not Found. ", username));
        }
    }

    public Users findByUsernameAndPassword(String username, String password) {
        try {
            return usersRepo.findByUsernameAndPassword(username, password);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(String.format("Username and Password not correct"));
        }
    }

    public boolean existsByUsernameAndPassword(String username, String password) {
            if(usersRepo.existsByUsernameAndPassword(username, password)){
             return true;
            }
        throw new NotFoundException(String.format("Username and Password not correct"));
    }

    @Override
    public List<Users> findAll() {
        return usersRepo.findAll();
    }

    public LoginResponse login(LoginBody loginBody){
        try {
            if(existsByUsernameAndPassword(loginBody.getUsername(), loginBody.getPassword())){
                UserDetails user = userDetailsService.loadUserByUsername(loginBody.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        user, user.getPassword(), user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);

                return new LoginResponse(jwtUtils.generateToken(findByUsername(loginBody.getUsername())));
            }
            throw new UnauthorizedException("Access denied.");
        }catch (Exception ex){
            throw new UnauthorizedException("Access denied.");
        }
    }
}
