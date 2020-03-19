package sree.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.context.RequestContext;
import static com.netflix.zuul.context.RequestContext.getCurrentContext;

public class ProxyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		boolean isMobile=false;
		RequestContext ctx = getCurrentContext();
		String param = ctx.getRequest().getParameter("source");
		if(param!=null && param.equals("mobile")) {
			isMobile=true;
		}
		return isMobile;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("calling a filater!");
		return false;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
	
		return 1;
	}

	
}
