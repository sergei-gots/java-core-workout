package pro.sky.java.course_2_core.hw_2_8_emplbook.service;

import org.springframework.stereotype.Service;

@Service
public class DepartmentsServiceImpl extends DepartmentsServiceImplAbstract
implements DepartmentsService {
    public DepartmentsServiceImpl() {
        initEmployees();
    }
}
