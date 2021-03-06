/***********************************************************************

	This file is part of KEEL-software, the Data Mining tool for regression, 
	classification, clustering, pattern mining and so on.

	Copyright (C) 2004-2010
	
	F. Herrera (herrera@decsai.ugr.es)
    L. S�nchez (luciano@uniovi.es)
    J. Alcal�-Fdez (jalcala@decsai.ugr.es)
    S. Garc�a (sglopez@ujaen.es)
    A. Fern�ndez (alberto.fernandez@ujaen.es)
    J. Luengo (julianlm@decsai.ugr.es)

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see http://www.gnu.org/licenses/
  
**********************************************************************/

/**
 * <p>
 * @author Written by Crist�bal Romero Morales (University of Oviedo) 01/07/2008
 * @author Modified by Xavi Sol� (La Salle, Ram�n Llull University - Barcelona) 16/12/2008
 * @version 1.1
 * @since JDK1.2
 * </p>
 */

package keel.Algorithms.Rule_Learning.C45RulesSA;

import java.io.BufferedWriter;
import java.io.StreamTokenizer;
import java.io.IOException;

import keel.Dataset.Attributes;

public abstract class Algorithm
{
  /** The name of the file that contains the information to build the model. */
  protected static String modelFileName = "";

  /** The name of the file that contains the information to make the training. */
  protected static String trainFileName = "";

  /** The name of the file that contains the information to make the test. */
  protected static String testFileName = "";

  /** The name of the train output file. */
  protected static String trainOutputFileName;

  /** The name of the test output file. */
  protected static String testOutputFileName;

  /** The name of the result file. */
  protected static String resultFileName;

  /** Correctly classified itemsets. */
  protected int correct = 0;

  /** Correctly classified in test. */
  protected int testCorrect = 0;

  /** The model dataset. */
  protected MyDataset modelDataset;

  /** The train dataset. */
  protected MyDataset trainDataset;

  /** The test dataset. */
  protected MyDataset testDataset;

  /** The log file. */
  protected static BufferedWriter log;

  /** The instant of starting the algorithm. */
  protected long startTime = System.currentTimeMillis();

  /** Function to initialize the stream tokenizer.
   *
   * @param tokenizer The tokenizer.
   */
  protected void initTokenizer( StreamTokenizer tokenizer )
  {
    tokenizer.resetSyntax();
    tokenizer.whitespaceChars( 0, ' ' );
    tokenizer.wordChars( ' '+1,'\u00FF' );
    tokenizer.whitespaceChars( ',',',' );
    tokenizer.quoteChar( '"' );
    tokenizer.quoteChar( '\''  );
    tokenizer.ordinaryChar( '=' );
    tokenizer.ordinaryChar( '{' );
    tokenizer.ordinaryChar( '}' );
    tokenizer.ordinaryChar( '[' );
    tokenizer.ordinaryChar( ']' );
    tokenizer.eolIsSignificant( true );
  }


  /** Function to get the name of the relation and the names, types and possible values of every attribute in
   *  a dataset.
   *
   * @return The name and the attributes of the relation.
   */
  protected String getHeader()
  {
    String header;
    header = "@relation "+Attributes.getRelationName()+"\n";
    header += Attributes.getInputAttributesHeader();
    header += Attributes.getOutputAttributesHeader();
    header += Attributes.getInputHeader()+"\n";
    header += Attributes.getOutputHeader()+"\n";
    header += "@data\n";


    return header;
  }

  /** Puts the tokenizer in the first token of the next line.
   *
   * @param tokenizer The tokenizer which reads this function.
   *
   * @return True if reaches the end of file. False otherwise.
   *
   * @throws Exception	If cannot read the tokenizer.
   */
  protected boolean getNextToken( StreamTokenizer tokenizer ) throws Exception
  {
    try
    {
      if ( tokenizer.nextToken() == StreamTokenizer.TT_EOF )
        return false;
      else
      {
        tokenizer.pushBack();
        while ( tokenizer.nextToken() != StreamTokenizer.TT_EOL );
        while ( tokenizer.nextToken() == StreamTokenizer.TT_EOL );

        if ( tokenizer.sval == null )
          return false;
        else
          return true;
      }
    }
    catch( Exception e )
    {
      System.err.println( e.getMessage() );
      return false;
    }
  }

}
