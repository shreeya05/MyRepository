package com.example.repository;

import javax.annotation.Resources;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder.DelimitedBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.model.batchUser;

@Configuration
//@EnableBatchProcessing
public class SpringBatchConfig {

	@Bean
	public Job job(JobBuilderFactory JobBuilderFactory,StepBuilderFactory stepbuilderfactory ,
					ItemReader<batchUser> itemReader,
					ItemProcessor<batchUser,batchUser> itemProcessor,
					ItemWriter<batchUser> itemWriter) {
		//.get recevice what kind of job you want
		
		//ETL-File-Load this step name
		//chunk we process in chunk
		Step step = stepbuilderfactory.get("ETL-File-Load")
				.<batchUser,batchUser>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		//incrementer nothing but sequences of id which well assign to every run 
		//RunIdIncrementer()  this well jush run my batch id in sequences
		//if you have multiple steps you can use either start and flow
		Job job=JobBuilderFactory.get("ETL-Load")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
		
		return job;
		
		//if you have multiple step instead of start you have to use flow(step).next(step)
	}
	
	
	@Bean
	public FlatFileItemReader<batchUser> itemReader(@Value("${input}") Resource resource){
		
		FlatFileItemReader<batchUser> flatfileItemReader = new FlatFileItemReader<batchUser>();
		flatfileItemReader.setResource(resource);
		flatfileItemReader.setName("Tsv-reader");
		flatfileItemReader.setLinesToSkip(1);
		flatfileItemReader.setLineMapper(lineMapper());
		return flatfileItemReader;
	}


	@Bean
	private LineMapper<batchUser> lineMapper() {
		DefaultLineMapper<batchUser> defaultLineMapper=new DefaultLineMapper<batchUser>();
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(" ");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String [] {"id","firstName","middleName","lastName","percentage"});
		//we need to fill to this particular pojo
		BeanWrapperFieldSetMapper<batchUser> beanWrapperFieldSetMapper=new BeanWrapperFieldSetMapper<batchUser>();
		//map everthing this to that
		beanWrapperFieldSetMapper.setTargetType(batchUser.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		//bean configuration 
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return defaultLineMapper;
	}
}
