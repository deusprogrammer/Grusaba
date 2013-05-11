package com.ponychan.forum

class PaginationService {

	def sortAndPaginate(def list, def params) { 
		if (list.size() == 0) { 
	      return [totalRecords: 0, list: list] 
	    }
		
		list = list.sort{it.lastUpdated.getTime()}.reverse()

		 // Subset the results to the specified page 
	    if (params?.offset && params?.max) { 
	      def offset = params.offset.toInteger() 
	      def max = params.max
	      def endRange = (offset + max - 1) <= (list.size() - 1) ? (offset + max - 1) : list.size() - 1 
	      def range = offset..endRange 
	
	      return [totalRecords: list.size(), list: list[range]] 
	    } 
	
	    return [totalRecords: list.size(), list: list] 
	  } 
}
