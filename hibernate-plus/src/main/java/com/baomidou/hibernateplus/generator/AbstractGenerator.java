/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.hibernateplus.generator;


import com.baomidou.hibernateplus.generator.config.DataSourceConfig;
import com.baomidou.hibernateplus.generator.config.GlobalConfig;
import com.baomidou.hibernateplus.generator.config.PackageConfig;
import com.baomidou.hibernateplus.generator.config.StrategyConfig;
import com.baomidou.hibernateplus.generator.config.TemplateConfig;
import com.baomidou.hibernateplus.generator.config.builder.ConfigBuilder;

/**
 * <p>
 * 插件基类，用于属性配置 设计成抽象类主要是用于后期可扩展，共享参数配置。
 * </p>
 *
 * @author YangHu
 * @since 2016/8/30
 */
public abstract class AbstractGenerator {

	/**
	 * 数据源配置
	 */
	private DataSourceConfig dataSource;

	/**
	 * 数据库表配置
	 */
	private StrategyConfig strategy;

	/**
	 * 包 相关配置
	 */
	private PackageConfig packageInfo;

	/**
	 * 模板 相关配置
	 */
	private TemplateConfig template;

	/**
	 * 全局 相关配置
	 */
	private GlobalConfig globalConfig;

	protected ConfigBuilder config;

	/**
	 * 初始化配置
	 */
	protected void initConfig() {
		if (null == config) {
			config = new ConfigBuilder(packageInfo, dataSource, strategy, template, globalConfig);
		}
	}

	public DataSourceConfig getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSourceConfig dataSource) {
		this.dataSource = dataSource;
	}

	public StrategyConfig getStrategy() {
		return strategy;
	}

	public void setStrategy(StrategyConfig strategy) {
		this.strategy = strategy;
	}

	public PackageConfig getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(PackageConfig packageInfo) {
		this.packageInfo = packageInfo;
	}

	public TemplateConfig getTemplate() {
		return template;
	}

	public void setTemplate(TemplateConfig template) {
		this.template = template;
	}

	public ConfigBuilder getConfig() {
		return config;
	}

	public void setConfig(ConfigBuilder config) {
		this.config = config;
	}

	public GlobalConfig getGlobalConfig() {
		return globalConfig;
	}

	public void setGlobalConfig(GlobalConfig globalConfig) {
		this.globalConfig = globalConfig;
	}

}
