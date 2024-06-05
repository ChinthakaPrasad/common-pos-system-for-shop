package BO;

import dao.UserDao;
import dto.UserDto;
import entity.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserBo implements SuperBo<UserDto>{
    private UserDao userDao = new UserDao();

    @Override
    public boolean save(UserDto dto) {
        try {
            User newUser = new User(
                    dto.getUserName(),
                    dto.getEmail(),
                    dto.getPhoneNumber(),
                    dto.getNic(),
                    toHexString(getSHA(dto.getPassword()))
            );

            return userDao.saveUser(newUser);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(UserDto dto) {
        return false;
    }

    @Override
    public boolean delete(UserDto dto) {
        return false;
    }

    @Override
    public List<UserDto> all() {
        return null;
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        /* MessageDigest instance for hashing using SHA256 */
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        /* digest() method called to calculate message digest of an input and return array of byte */
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        /* Convert byte array of hash into digest */
        BigInteger number = new BigInteger(1, hash);

        /* Convert the digest into hex value */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Pad with leading zeros */
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public boolean checkUser(String username, String password) throws NoSuchAlgorithmException {
        List<User> userList = userDao.getAll();

        String hashPassword = toHexString(getSHA(password));

        boolean isValidUser = false;

        for(User user: userList){
            if (user.getPassword().equals(hashPassword)){
                if(user.getUserName().equals(username)){
                    isValidUser = true;
                }
            }
        }
        return true;
    }
}
