/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Caratacus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.baomidou.hibernateplus.entity;

import com.baomidou.hibernateplus.converter.BeanConverter;
import com.baomidou.hibernateplus.exceptions.HibernatePlusException;
import com.baomidou.hibernateplus.utils.Assert;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * <p>
 * 统一VO TO互转方法
 * </p>
 *
 * @author Caratacus
 * @date 2016-11-23
 */
@MappedSuperclass
public class Convert implements Serializable {

	/**
	 * 互转方法
	 * 
	 * @param clazz
	 * @param <T>
	 * @return
	 */
    public <T> T convert(Class<T> clazz) {
		Assert.isNull(clazz);
		try {
			T entity = clazz.newInstance();
			return BeanConverter.convert(entity, this);
		} catch (Exception e) {
			throw new HibernatePlusException("Error: Conversion Object Failed. Cause:" + e);
		}
	}

}