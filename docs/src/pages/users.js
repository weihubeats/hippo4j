import React from "react";
import Layout from "@theme/Layout";
import companyData from "@site/static/json/company_logo.json";
import useBaseUrl from "@docusaurus/useBaseUrl";
import Translate from "@docusaurus/Translate";
function CompanyCards({ companies }) {
  return (
    <div className="grid sm:grid-cols-2 grid-cols-1 md:px-16 md:grid-cols-3 lg:grid-cols-6 gap-4 mb-16 lg:px-2 px-10">
      {/* Filter out those without a logo. */}
      {companies
        .filter((comapny) => comapny.logo.length > 0)
        .map((company) => (
          <div
            onClick={() => window.open(company.url)}
            key={company.url}
            // className="bg-white rounded-lg overflow-hidden shadow-sm transform cursor-pointer transition-all duration-500 hover:scale-110"
            className="bg-white rounded-lg overflow-hidden shadow-sm transform cursor-pointer transition-all duration-500 hover:scale-110"
            style={{ border: "1px solid #E5E7EB" }}
          >
            <div className="flex dark:text-black items-center justify-center h-28">
              <div
                className="h-22 w-24 object-contain"
                style={{ position: "relative" }}
              >
                <img
                  src={useBaseUrl(company.logo)}
                  alt={`${company.name}`}
                  className="h-22 w-24 object-contain"
                />
              </div>
            </div>
          </div>
        ))}
    </div>
  );
}
export default function OurUsers() {
  return (
    <Layout title="OurUsers" description="companies using our product">
      <div className="max-w-screen-lg mx-auto dark:text-white">
        {/* text description*/}
        <div className="max-w-screen-sm sm:mx-auto mx-10 text-center my-8 mt-16 ">
          <div className="text-center mt-8">
            <h2 className="text-3xl font-bold my-4">
              <Translate
                id="companyPage.title"
                description="the title for the company page"
              >
                Who is using Hippo4j?
              </Translate>
            </h2>
            <div
              className="mx-auto h-1 bg-gradient-to-r from-green-400 to-blue-500 my-6"
              style={{ width: "30%" }}
            ></div>
          </div>
          <div className="flex flex-col items-center mx-auto">
            <p className="text-lg leading-loose mb-2 max-w-1/2">
              <Translate
                id="companyPage.descriptionText"
                description="the description for the company page"
              >
                Thank you very much for your attention and support to Hippo4j.
                This is our greatest motivation to move forward.
              </Translate>{" "}
            </p>
            <p className="text-lg mb-4 max-w-1/2 leading-loose">
              <Translate
                id="companyPage.questionText"
                description="the text for the company question"
              >
                Are you using Hippo4j?
              </Translate>{" "}
              <a
                href="https://github.com/opengoofy/hippo4j/issues/13"
                className="text-blue-400 hover:text-blue-500 font-medium"
              >
                <Translate
                  id="companyPage.linkText"
                  description="the text for the company page link"
                >
                  Click to register
                </Translate>
              </a>
            </p>
          </div>
        </div>
        {/* company logo display */}
        <CompanyCards companies={companyData} className="ml-0" />
      </div>
    </Layout>
  );
}
