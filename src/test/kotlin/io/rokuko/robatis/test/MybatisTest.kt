package io.rokuko.robatis.test

import io.rokuko.robatis.io.Resources
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MybatisTest {

    @Test
    fun test1(){
        val inputStream: InputStream = Resources.getResourceAsStream("mybatis-config.xml")
        val content = BufferedReader(InputStreamReader(inputStream)).useLines { lines ->
            val results = StringBuilder()
            lines.forEach {
                results.append(it)
            }
            results.toString()
        }
        println(content)
//        val sqlSessionFactory: SqlSessionFactory = SqlSessionFactoryBuilder().build(inputStream)
//        val sqlSession: SqlSession = sqlSessionFactory.openSession()
//        val mapper: ProductMapper = sqlSession.getMapper(ProductMapper::class.java)
//        val productList: List<Product> = mapper.getProductList()
//        println(productList)
    }

}