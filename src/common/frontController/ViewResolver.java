package common.frontController;

public class ViewResolver {

	private String prefix = "/WEB-INF/views/";
	private String subfix = ".jsp";
	private String uri = "";

	public ViewResolver() {

	}

	public ViewResolver(String uri) {
		this.uri = uri;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSubfix() {
		return subfix;
	}

	public void setSubfix(String subfix) {
		this.subfix = subfix;
	}

	public String getView() {

		return prefix + uri + subfix;
	}

}
