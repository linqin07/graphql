package com.config;

import graphql.language.StringValue;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.util.Kit;
import graphql.schema.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static graphql.scalars.util.Kit.typeName;


/**
 * @Description:
 * @author: LinQin
 * @date: 2021/06/28
 */
@Slf4j
@Configuration
public class CustomScalarTypeConfig {

    private static final String DATE_FORMAT_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public GraphQLScalarType graphQLLong() {
        return ExtendedScalars.GraphQLLong;
    }

    @Bean
    public GraphQLScalarType graphQLDate() {
        return GraphQLScalarType
                .newScalar()
                .name("Date")
                .description("Date 类型")
                .coercing(new Coercing<Date, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        return new SimpleDateFormat(DATE_FORMAT_PATTERN_DEFAULT).format((Date) dataFetcherResult);
                    }
                    @Override
                    public Date parseValue(Object input) throws CoercingParseValueException {
                        if (input instanceof String) {
                            try {
                                return new SimpleDateFormat(DATE_FORMAT_PATTERN_DEFAULT).parse((String) input);
                            } catch (ParseException e) {
                                throw new CoercingParseValueException(e);
                            }
                        }
                        throw new CoercingParseValueException(
                                "Expected a 'String' but was '" + Kit.typeName(input) + "'."
                        );
                    }
                    @Override
                    public Date parseLiteral(Object input) throws CoercingParseLiteralException {
                        if (!(input instanceof StringValue)) {
                            throw new CoercingParseLiteralException(
                                    "Expected AST type 'StringValue' but was '" + typeName(input) + "'."
                            );
                        }
                        try {
                            return new SimpleDateFormat(DATE_FORMAT_PATTERN_DEFAULT).parse(((StringValue) input).getValue());
                        } catch (ParseException e) {
                            log.error("日期格式转化错误");
                            throw new CoercingParseValueException(e);
                        }
                    }
                })
                .build();
    }
}