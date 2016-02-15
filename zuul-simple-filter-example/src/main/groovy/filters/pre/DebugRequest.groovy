/*
 * Copyright 2013 Netflix, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */
package filters.pre

import com.netflix.zuul.filters.FilterPriority;
import com.netflix.zuul.filters.ZuulFilter

import rx.Observable;

import com.netflix.zuul.context.Debug
import com.netflix.zuul.context.Headers;
import com.netflix.zuul.context.ZuulMessage;

import javax.servlet.http.HttpServletRequest
/**
 * @author Mikey Cohen
 * Date: 3/12/12
 * Time: 1:51 PM
 */
class DebugRequest implements ZuulFilter {
    @Override
    String filterType() {
        return 'pre'
    }

    @Override
    int filterOrder() {
        return 10000
    }

	@Override
	public boolean shouldFilter(ZuulMessage msg) {
		return true;
	}

	@Override
	public boolean isDisabled() {
		return false;
	}

	@Override
	public String filterName() {
		return "Header-Display-Filter";
	}

	@Override
	public FilterPriority getPriority() {
		return FilterPriority.HIGH;
	}

	
	public Observable applyAsync(ZuulMessage input) {
		Headers headers = input.getHeaders();
		
        headers.entries().each {
			header -> println "REQUEST:: >" + header.key + ":" header.value
		} 
		
   	}

}
