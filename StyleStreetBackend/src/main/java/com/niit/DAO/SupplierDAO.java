package com.niit.DAO;
import java.util.List;
import com.niit.Model.Supplier;

public interface SupplierDAO 
  {
	public boolean addSupplier (Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public boolean deleteSupplier (Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> getSuppliers();
}