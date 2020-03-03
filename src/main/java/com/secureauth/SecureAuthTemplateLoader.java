package com.secureauth;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.JsonNodeValueResolver;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.cache.GuavaTemplateCache;
import com.github.jknack.handlebars.context.FieldValueResolver;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.context.MethodValueResolver;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.github.jknack.handlebars.io.TemplateSource;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component
public class SecureAuthTemplateLoader {
  private Handlebars handlebars;
  
  @PostConstruct
  public void loadHandlebarTemplates() {
	 TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
	 final Cache<TemplateSource, Template> templateCache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).maximumSize(1000).build();
	 setHandlebars(new Handlebars(loader).with((new GuavaTemplateCache(templateCache))));
  }
  
  public Handlebars getHandlebars() {
	  return handlebars;
  }
  
  public void setHandlebars(Handlebars handlebars) {
	  this.handlebars = handlebars;
  }
  
  public Template getTemplate(String templateName) throws IOException {
	  Template template = this.getHandlebars().compile(templateName);
	  return template;  
  }
  
  public Context getContext(JsonNode model) {
	  Context context = Context
				.newBuilder(model)
				.resolver(JsonNodeValueResolver.INSTANCE,JavaBeanValueResolver.INSTANCE,FieldValueResolver.INSTANCE,
						MapValueResolver.INSTANCE,
						MethodValueResolver.INSTANCE)
				.build();
		return context;
  }
  
  
}

