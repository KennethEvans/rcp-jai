package net.kenevans.jai.plugin;

import javax.imageio.ImageIO;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class JAIPlugin extends Plugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.scatteringsw.xrays.jai";
    public static final boolean debug = false;

    // The shared instance
    private static JAIPlugin plugin;

    /**
     * The constructor
     */
    public JAIPlugin() {
        if(debug) {
            System.out.println("JAIPlugin CTOR");
        }
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        // System.out.println("org.scatteringsw.xrays.jai start()");
        // Is apparently necessary to get it to find JAI plug-ins and load them
        // with
        // this context classloader
        if(debug) {
            System.out.println("JAIPlugin.start");
        }
        ImageIO.scanForPlugins();
        if(debug) {
            System.out
                .println("JAIPlugin.start: after ImageIO.scanForPlugins()");
        }
        super.start(context);
        if(debug) {
            System.out.println("JAIPlugin.start: after super.start(context)");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static JAIPlugin getDefault() {
        return plugin;
    }

}
