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

package keel.Algorithms.Associative_Classification.ClassifierCBA2;

/**
 * <p>Title: Replace</p>
 *
 * <p>Description: This class contains the representation of the "Replace" structure <cRule, dID, y></p>
 *
 * <p>Copyright: Copyright KEEL (c) 2007</p>
 *
 * <p>Company: KEEL </p>
 *
 * @author Written by Jesus Alcal� (University of Granada) 09/02/2010
 * @version 1.0
 * @since JDK1.5
 */

public class Replace implements Comparable{
	/**
	 * Auxiliary class to store the representation of the "Replace" structure
	 * <cRule, dID, y>
	 */
  int dID, y;
  int cRule;

  /**
   * <p>
   * Default Constructor
   * </p>
   */
  public Replace() {
  }

  /**
   * <p>
   * Parameters Constructor
   * </p>
   * @param cRule int Position in the rule set for the rule that correctly classifies the "dID" instance
   * @param dID int Position of the correctly classified example
   * @param y int Class of the "dID" example
   */
  public Replace(int cRule, int dID, int y) {
	this.cRule = cRule;
    this.dID = dID;
    this.y = y;
  }

  /**
   * <p>
   * Clone function
   * </p>
   */
  public Replace clone () {
	Replace r = new Replace (this.cRule, this.dID, this.y);

	return (r);
  }

  /**
   * <p>
   * It returns the position in the training dataset for the example stored in the structure
   * </p>
   * @return int Position in the training dataset for the example stored in the structure
   */
  public int getdID () {
    return (this.dID);
  }

  /**
   * <p>
   * It sets in the structure the position in the training dataset of the wanted example
   * </p>
   * @param dID int Position in the training dataset of the wanted example
   */
  public void setdID (int dID) {
    this.dID = dID;
  }

  /**
   * <p>
   * It returns the class for the example stored in the structure
   * </p>
   * @return int Class for the example stored in the structure
   */
  public int gety () {
    return (this.y);
  }

  /**
   * <p>
   * It sets in the structure the class of the example
   * </p>
   * @param y int Class of the example
   */
  public void sety (int y) {
    this.y = y;
  }

  /**
   * <p>
   * It returns the position of the best rule that correctly classifies the example stored in the structure
   * </p>
   * @return int Position of the best rule that correctly classifies the example stored in the structure
   */
  public int getcRule () {
    return (this.cRule);
  }

  /**
   * <p>
   * It sets the position of the best rule that correctly classifies the example stored in the structure
   * </p>
   * @param cRule int Position of the best rule that correctly classifies the example stored in the structure
   */
  public void setcRule (int cRule) {
    this.cRule = cRule;
  }

  /**
   * Function to compare objects of the Structure class
   * Necessary to be able to use "sort" function
   * It sorts in an decreasing order of example's position
   */
  public int compareTo(Object a) {
    if ( ( (Replace) a).dID < this.dID) {
      return 1;
    }
    if ( ( (Replace) a).dID > this.dID) {
      return -1;
    }
    return 0;
  }

}

