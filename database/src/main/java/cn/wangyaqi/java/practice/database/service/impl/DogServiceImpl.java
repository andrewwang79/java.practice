package cn.wangyaqi.java.practice.database.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wangyaqi.java.practice.database.entity.Dog;
import cn.wangyaqi.java.practice.database.service.DogService;
import cn.wangyaqi.java.practice.database.mapper.DogMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DogServiceImpl extends ServiceImpl<DogMapper, Dog>
implements DogService{

}