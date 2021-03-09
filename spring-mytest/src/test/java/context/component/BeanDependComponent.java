package context.component;

/**
 * @author fengchao
 * @version BeanDependComponent.java v 0.1 2021年03月02日 下午5:50 fengchao Exp $
 */
public class BeanDependComponent {

	private String componentName;

	private MyTestBean myTestBean;

	public BeanDependComponent(String componentName) {
		this.componentName = componentName;
	}

	public BeanDependComponent() {
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public MyTestBean getMyTestBean() {
		return myTestBean;
	}

	public void setMyTestBean(MyTestBean myTestBean) {
		this.myTestBean = myTestBean;
	}
}
