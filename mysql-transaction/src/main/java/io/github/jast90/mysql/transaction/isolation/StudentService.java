package io.github.jast90.mysql.transaction.isolation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void test(){

    }

}
