package io.rokuko.robatis.test

import org.junit.jupiter.api.Test
import java.io.InputStream

class MybatisTest {

    @Test
    fun test1(){
        val inputStream: InputStream = Resources.getResourceAsStream("mybatis-config.xml")
        val sqlSessionFactory: SqlSessionFactory = SqlSessionFactoryBuilder().build(inputStream)
        val sqlSession: SqlSession = sqlSessionFactory.openSession()
        val mapper: ProductMapper = sqlSession.getMapper(ProductMapper::class.java)
        val productList: List<Product> = mapper.getProductList()
        println(productList)
    }

}