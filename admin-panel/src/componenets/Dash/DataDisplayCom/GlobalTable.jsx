/* eslint-disable react/prop-types */
const GlobalTable = ({ columns, data }) => {
  return (
    <div className="relative overflow-x-auto max-h-[35rem] overflow-y-auto  w-full rounded-lg shadow-md">
      <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400 max-h-[35rem] overflow-y-auto">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            {columns.map((col) => (
              <th key={col.key} className="px-6 py-3">
                {col.label}
              </th>
            ))}
          </tr>
        </thead>
        <tbody>
          {data.map((row, rowIndex) => (
            <tr
              key={rowIndex}
              className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 border-gray-200"
            >
              {columns.map((col) => (
                <td key={col.key} className="px-6 py-4">
                  {Array.isArray(row[col.key])
                    ? row[col.key].length
                    : row[col.key]}
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default GlobalTable;

// Usage Example
// const columns = [
//   { key: "product", label: "Product name" },
//   { key: "color", label: "Color" },
//   { key: "category", label: "Category" },
//   { key: "price", label: "Price" },
// ];
// const data = [
//   { product: "Apple MacBook Pro 17\"", color: "Silver", category: "Laptop", price: "$2999" },
//   { product: "Microsoft Surface Pro", color: "White", category: "Laptop PC", price: "$1999" },
//   { product: "Magic Mouse 2", color: "Black", category: "Accessories", price: "$99" },
// ];
// <GlobalTable columns={columns} data={data} />;
