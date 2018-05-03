package php.pkg.jphpswtext.classes;

import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import php.pkg.jphpswtext.JphpSwtExtExtension;
import php.pkg.jphpswtext.support.EventManager;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Getter;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.exceptions.CriticalException;
import php.runtime.exceptions.JPHPException;
import php.runtime.exceptions.support.ErrorType;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Namespace(JphpSwtExtExtension.NS)
abstract public class UIWidget<T extends Widget> extends BaseWrapper<T> {
    public UIWidget(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UIWidget(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public T getWrappedObject() {
        return super.getWrappedObject();
    }

    @Getter
    public Display getDisplay() {
        return getWrappedObject().getDisplay();
    }

    @Signature
    public void free() {
        getWrappedObject().dispose();
    }

    @Signature
    public boolean isFree() {
        return getWrappedObject().isDisposed();
    }

    @Signature
    public void data(String name, Object value) {
        getWrappedObject().setData(name, value);
    }

    @Signature
    public Object data(String name) {
        return getWrappedObject().getData(name);
    }

    @Signature
    public void bind(Environment env, String event, Invoker invoker) throws InvocationTargetException, IllegalAccessException {
        EventManager.create(this, event).bind(env, invoker);
    }

    @Signature
    public void unbind(Environment env, String event) throws InvocationTargetException, IllegalAccessException {
        EventManager.create(this, event).unbind(env);
    }

    @Signature
    public void trigger(Environment env, String event) throws InvocationTargetException, IllegalAccessException {
        EventManager.create(this, event).trigger(env);
    }
}