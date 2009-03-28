/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modbuspal.automation;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Defines a generator. An automation is made of a list of generators.
 * @author nnovic
 */
public class Generator
{   
    private ImageIcon icon;
    protected int duration = 10;
    protected double initialValue = 0.0;
    private ArrayList<GeneratorListener> generatorListeners = new ArrayList<GeneratorListener>();
    private JPanel controlPanel;

    /**
     * Creates a generator with default values, icon and control panel.
     */
    public Generator()
    {
        setIcon("/modbuspal/automation/Generator.png");
        controlPanel = createControlPanel();
    }

    private JPanel createControlPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        JLabel defaultLabel = new JLabel("No parameters.");
        panel.add(defaultLabel, BorderLayout.CENTER);
        return panel;
    }


    /**
     * The subclass can use this mehod to change the default icon of the generator.
     * The icon is the image that is visible on the left of the generator's control
     * panel, in the automation editor.
     * @param iconUrl
     */
    protected void setIcon(String iconUrl)
    {
        // test current direcory
        File file = new File(iconUrl);
        System.out.println(file.getAbsolutePath());

        URL url = getClass().getResource(iconUrl);
        icon = new ImageIcon(url);
    }




    /**
     * Get the icon that is associated with this generator.
     * @return icon of the generator.
     */
    public Icon getIcon()
    {
        return icon;
    }

    /**
     * Get the configured duration of the generator.
     * @return duration of the generator, in seconds.
     */
    public int getDuration()
    {
        return duration;
    }

    /**
     * Get the control panel of the generator.
     * @return the control panel of the generator.
     */
    public JPanel getControlPanel()
    {
        return controlPanel;
    }

    
    void setInitialValue(double value)
    {
        initialValue = value;
    }

    public double getValue(double time)
    {
        return 0.0;
    }


    public final void load(Node genNode)
    {
        NamedNodeMap attributes = genNode.getAttributes();

        Node durNode = attributes.getNamedItem("duration");
        String durVal= durNode.getNodeValue();
        duration = Integer.parseInt(durVal);

        loadSettings( genNode.getChildNodes() );
    }

    protected void loadSettings(NodeList childNodes)
    {
        return;
    }

    void setDuration(int val)
    {
        duration = val;
    }


    void notifyGeneratorHasEnded()
    {
        for(GeneratorListener l:generatorListeners)
        {
            l.generatorHasEnded(this);
        }
    }

    void notifyGeneratorHasStarted()
    {
        for(GeneratorListener l:generatorListeners)
        {
            l.generatorHasStarted(this);
        }
    }

    void removeAllGeneratorListeners()
    {
        generatorListeners.clear();
    }

    public final void save(OutputStream out)
    throws IOException
    {
        String openTag = createOpenTag();
        out.write(openTag.getBytes());

        saveSettings(out);

        String closeTag = "</generator>\r\n";
        out.write(closeTag.getBytes());
    }

    
    public String getClassName()
    {
        return getClass().getSimpleName();
    }

    private String createOpenTag()
    {
        StringBuffer tag = new StringBuffer("<generator");
        tag.append(" class=\""+ getClassName() +"\"");
        tag.append(" duration=\""+ String.valueOf(duration) +"\"");
        tag.append(">\r\n");
        return tag.toString();
    }

    protected void saveSettings(OutputStream out)
    throws IOException
    {
        return;
    }

    public void addGeneratorListener(GeneratorListener l)
    {
        assert( generatorListeners.contains(l) == false );
        generatorListeners.add(l);
    }

    public void removeGeneratorListener(GeneratorListener l)
    {
        assert( generatorListeners.contains(l) == true );
        generatorListeners.remove(l);
    }

}
