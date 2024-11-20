package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Customer;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginRepository {
    @Results(
            id = "customer",
            value = {

                    @Result(column = "c_id", property = "id"),
                    @Result(column = "c_password", property = "password"),
                    @Result(column = "c_c_alias", property = "alias"),
                    @Result(column = "p_uuid", property = "people", one = @One(resultMap = PeopleRepository.PEOPLE))
            }
    )
    @Select(value = "")
    Customer customer();
    @ResultMap(value = "customer")
    @Select("SELECT * FROM customer c inner join people p on c.p_uuid = p.p_uuid WHERE c_id = #{id}")
    Customer findId(String id);

    @Select("SELECT * FROM customer WHERE c_spassword = #{password}")
    Customer findPassword(String password);
    @Insert("""
        INSERT INTO customer(c_id, c_password, c_name, c_identity, c_email, c_contact, c_address)
        VALUES (#{id},#{password},#{name},#{identity},#{email},#{contact},#{address})
    """)
    void UserInfo (Customer customer);



}
