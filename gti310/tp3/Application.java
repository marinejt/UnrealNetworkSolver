package gti310.tp3;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import gti310.tp3.parser.*;
import gti310.tp3.solver.PathSolver;
import gti310.tp3.writer.PathWriter;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is fa�ing.
 * 
 * @author Fran�ois Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		System.out.println("Unreal Networks Solver !");
		System.out.println(args[0]);
		PathParser parser = new PathParser();
		PathSolver solver = new PathSolver();
		PathWriter writer = new PathWriter();
		writer.write(args[1], solver.solve(parser.parse(args[0])));
	}
}
